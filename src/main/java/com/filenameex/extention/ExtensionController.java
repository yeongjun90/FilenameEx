package com.filenameex.extention;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.filenameex.models.ExtensionVO;
import com.filenameex.models.FileVO;

@RestController
public class ExtensionController {

	@Autowired
	private ExtensionService extensionService;

	@RequestMapping(value = "extensionList", method = RequestMethod.POST)
	public List<ExtensionVO> extensionList(ExtensionVO extensionVO) {
		return extensionService.extensionList();
	}

	@RequestMapping(value = "fixed_update", method = RequestMethod.POST)
	public Map fixed_update(ExtensionVO extensionVO) {
		return extensionService.fixed_update(extensionVO);
	}

	@RequestMapping(value = "custom_add", method = RequestMethod.POST)
	public Map custom_add(ExtensionVO extensionVO) {
		return extensionService.custom_add(extensionVO);
	}

	@RequestMapping(value = "extension_delete", method = RequestMethod.POST)
	public Map extension_delete(ExtensionVO extensionVO) {
		return extensionService.extension_delete(extensionVO);
	}

	@RequestMapping(value = "file_add", method = RequestMethod.POST)
	public Map file_add(FileVO fileVO) {
		return extensionService.file_add(fileVO);
	}

	@RequestMapping(value = "name_check", method = RequestMethod.POST)
	public Map name_check(ExtensionVO extensionVO) {
		return extensionService.name_check(extensionVO);
	}
}
