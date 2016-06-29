package com.taikang.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.udp.framework.common.datastructre.Dto;
import com.taikang.udp.framework.common.datastructre.impl.BaseDto;
import com.taikang.udp.framework.core.web.BaseController;
import com.taikang.udp.sys.action.IDictEntryAction;
import com.taikang.udp.sys.model.DictEntryBO;
import com.taikang.udp.sys.util.DictUtils;

@Controller("iuCommonController")
@RequestMapping(value = "")
public class IUCommonController extends BaseController {

	/**
	 * 获取【下拉框】指定字典类型的字典数据<br/>
	 * 
	 * @param dictType
	 * @param dictId
	 * @return list
	 * @author t-wuke
	 */
	@RequestMapping("/getDictCombox")
	@ResponseBody
	public String getDictCombox(@RequestParam(value = "dictType") String dictType) {
		List<DictEntryBO> list = DictUtils.getDictEntryList(dictType);
		List<Dto> listDto = new ArrayList<Dto>();
		Dto tmpDto = new BaseDto();
		for (DictEntryBO bo : list) {
			tmpDto = new BaseDto();
			tmpDto.put("dictId", bo.getDictId());
			tmpDto.put("dictName", bo.getDictName());
			listDto.add(tmpDto);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", listDto);
		Dto dto = new BaseDto();
		dto.put("list", listDto);
		return dto.toJson();

	}

	/**
	 * 获取【列表】全部字典数据
	 * 
	 * @param dictTypes
	 * @return totalList
	 * @author t-wuke
	 */
	@RequestMapping(value = "/getDictList", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getDictList(@RequestParam(value = "dictTypes") String dictTypes) {
		List<DictEntryBO> totalList = new ArrayList<DictEntryBO>();

		String[] dictTypeArr = dictTypes.split(",");

		for (String dictType : dictTypeArr) {
			//List<DictEntryBO> entryList = DictUtils.getDictEntryList(dictType);
			List<DictEntryBO> entryList = getDictEntryList(dictType);
			totalList.addAll(entryList);
		}
		Dto dto = new BaseDto();
		dto.put("list", totalList);
		return dto.toJson();

	}

	@Resource(name = IDictEntryAction.ACTION_ID)
	private IDictEntryAction dictEntryAction;

	private List<DictEntryBO> getDictEntryList(String dictType) {
		List<DictEntryBO> totalList = new ArrayList<DictEntryBO>();

		Dto param = new BaseDto();
		param.put("dict_type_id", dictType);
		param.put("status", 1);
		List<Dto> result = dictEntryAction.findAll(param);
		if (result != null && result.size() > 0) {
			for (Dto dto: result) {
				Dto bo = new BaseDto();
				bo.put("dictTypeId", dto.getAsString("Dict_Type_Id"));
				bo.put("dictId", dto.getAsString("Dict_ID"));
				bo.put("dictName", dto.getAsString("Dict_Name"));
				bo.put("status", dto.getAsString("Status"));
				bo.put("sortNo", dto.getAsString("Sort_No"));
				bo.put("parentId", dto.getAsString("Parent_ID"));
				bo.put("seqNo", dto.getAsString("Seq_No"));
				bo.put("backup1", dto.getAsString("Backup1"));
				bo.put("backup2", dto.getAsString("Backup2"));
				DictEntryBO dictEntryBO = BaseDto.toModel(DictEntryBO.class , bo);
				totalList.add(dictEntryBO);
			}
		}
		return totalList;
	}
}
