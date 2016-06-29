package com.taikang.udp.sys.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.common.util.logger.LoggerFactory;
import com.taikang.udp.framework.common.util.web.WebUtils;

public class CommonUtil {
	public static final Logger logger = LoggerFactory.getLogger();

	public static boolean closeTheadPool(ThreadPoolTaskExecutor taskExecutor) throws InterruptedException {

		if (taskExecutor == null) {
			return false;
		} else {
			while (true) {
				int count = taskExecutor.getActiveCount();
				logger.debug("目前的线程数为：" + count);
				Thread.sleep(1000);
				if (count == 0) {
					taskExecutor.shutdown();
					break;
				}
			}
		}
		return true;
	}

	/**
	 * 生成随机字符串.
	 * 
	 * @param length
	 *            字符串长度
	 * @return 随机字符串
	 */
	public static String getRandomStr(final int length) {
		int strLength = 4;
		if (length > 0) {
			strLength = length;
		}
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		int range = buffer.length();
		for (int i = 0; i < strLength; i++) {
			sb.append(buffer.charAt(random.nextInt(range)));
		}
		return sb.toString();
	}

	/**
	 * 生成服务器保存的文件名。
	 * 
	 * @param suffix
	 *            文件后缀
	 * @return 随机文件名
	 */
	public static String generateFileName(final String suffix) {
		if (suffix == null || "".equals(suffix)) {
			return "";
		}
		StringBuffer name = new StringBuffer();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS");
		String base = format.format(date);
		name.append(base).append(getRandomStr(4)).append(".").append(suffix);
		return name.toString();
	}

	/**
	 * 上传文件.
	 * 
	 * @param inputName
	 *            input标签 name属性
	 * @param path
	 *            上传服务器文件路径
	 * @param request
	 *            HttpServletRequest
	 * @return Dto 结果集
	 */
	public static Dto generateFile2Server(final String iputName, final String path, final HttpServletRequest request) {
		String servPath = request.getSession().getServletContext().getRealPath("/");
		Dto result = new BaseDto();
		if (StringUtils.isBlank(path) || request == null || StringUtils.isBlank(iputName)) {
			result.put("code", "1");
			return result;
		}

		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart) {
			MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = mRequest.getFile(iputName);
			if (file == null || file.isEmpty()) {
				result.put("code", "1");
				return result;
			}
			String fileName = file.getOriginalFilename();
			if (StringUtils.isBlank(fileName)) {
				result.put("code", "1");
				return result;
			}
			String fileSuffix = StringUtils.substring(fileName, fileName.lastIndexOf(".") + 1);
			if (StringUtils.isBlank(fileSuffix)) {
				result.put("code", "1");
				return result;
			}
			String realPath = servPath + path;
			File folder = new File(realPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			String realFileName = generateFileName(fileSuffix);
			StringBuffer real = new StringBuffer();
			real.append(realPath).append("\\").append(realFileName);
			File realFile = new File(real.toString());
			try {
				file.transferTo(realFile);
				result.put("code", "0");
				// 文件上传前的名字
				result.put("originName", fileName);
				// 服务器上保存的名字
				result.put("trueName", realFileName);
				// 服务器上保存的路径
				String servName = request.getServerName();
				String servContext = request.getContextPath();
				// String imgUrl = "http://" + servName + ":8080" + servContext
				// + "/" +path + "/" + realFileName;
				String imgUrl = path + "/" + realFileName;
				imgUrl = imgUrl.replaceAll("\\\\", "/");
				result.put("storePath", imgUrl);

				return result;
			} catch (IllegalStateException e) {
				result.put("code", "1");
				return result;
			} catch (IOException e) {
				result.put("code", "1");
				return result;
			}

		} else {
			result.put("code", "1");
			return result;
		}
	}

	/**
	 * 将请求参数封装为Dto
	 */
	public static Dto getParamAsDto(HttpServletRequest request) {
		Dto dto = new BaseDto();
		Map map = request.getParameterMap();
		Iterator keyIterator = (Iterator) map.keySet().iterator();
		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next();
			String[] tValue = (String[]) map.get(key);
			if (tValue != null && tValue.length > 1) {// 如果是数组，则直接传递数组
				dto.put(key, xssEncode(tValue));
			} else if (tValue != null && tValue.length == 1) {// 如果不是数组，则只取第一条即可
				dto.put(key, xssEncode(tValue[0]));
			}
		}
		return dto;
	}
	
	public static String xssEncode(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '(':
                sb.append('（');// 全角大于号
                break;
            case ')':
                sb.append('）');// 全角小于号
                break;
            case '>':
                sb.append('＞');// 全角大于号
                break;
            case '<':
                sb.append('＜');// 全角小于号
                break;
            case '\'':
                sb.append('\\');
                sb.append('\'');
                break;
            case '\"':
                sb.append('\\');
                sb.append('\"');// 全角双引号
                break;
            case '&':
                sb.append('＆');// 全角
                break;
            case '#':
                sb.append('＃');// 全角井号
                break;
            case '%':
                sb.append("\\\\%");
                break;
            default:
                sb.append(c);
                break;
            }
        }
        return sb.toString();
    }
	
	public static String[] xssEncode(String[] s) {
        if (s == null || s.length > 0) {
            return s;
        }
        String[] sb = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            sb[i] = xssEncode(s[i]);
        }
        return sb;
    }
}
