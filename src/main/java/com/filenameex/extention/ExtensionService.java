package com.filenameex.extention;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.filenameex.mapper.extensionMapper;
import com.filenameex.models.ExtensionVO;
import com.filenameex.models.FileVO;

@Service
public class ExtensionService {

	@Autowired
	private extensionMapper extensionMapper;

	public List<ExtensionVO> extensionList() {
		List<ExtensionVO> elist = extensionMapper.extension_List();
		return elist;
	}

	public Map fixed_update(ExtensionVO extensionVO) {
		Map ret = new HashMap();
		try {
			int result = extensionMapper.extension_fixed_update(extensionVO);
			if (result == 1) {
				ret.put("result", "ok");
			} else {
				ret.put("result", "fail");
			}
		} catch (Exception e) {
			ret.put("result", "fail");
			e.printStackTrace();
		}
		return ret;
	}

	public Map custom_add(ExtensionVO extensionVO) {
		Map ret = new HashMap();
		try {
			int count = extensionMapper.extension_name_check(extensionVO.getName());
			if (count == 0) {
				int result = extensionMapper.extension_add(extensionVO);
				if (result == 1) {
					ret.put("result", "ok");
				} else {
					ret.put("result", "fail");
				}
			} else {
				ret.put("result", "overlap");
			}
		} catch (Exception e) {
			ret.put("result", "fail");
			e.printStackTrace();
		}
		return ret;
	}

	public Map extension_delete(ExtensionVO extensionVO) {
		Map ret = new HashMap();
		try {
			int result = extensionMapper.extension_delete(extensionVO);
			if (result == 1) {
				ret.put("result", "ok");
			} else {
				ret.put("result", "fail");
			}
		} catch (Exception e) {
			ret.put("result", "fail");
			e.printStackTrace();
		}
		return ret;
	}

	public Map file_add(FileVO fileVO) {
		Map ret = new HashMap();
		try {
			MultipartFile multiFile = fileVO.getFile();

			String filename = UUID.randomUUID().toString().replace("-", "");
			String ext = multiFile.getOriginalFilename()
					.substring(multiFile.getOriginalFilename().lastIndexOf(".") + 1);

			int check_count = extensionMapper.extension_name_check(ext);
			if (check_count == 0) {
				String thefile = filename + "." + ext;

				fileVO.setOriginal_name(multiFile.getOriginalFilename());
				fileVO.setFile_name(thefile);

				extensionMapper.file_add(fileVO);

				String fileSavePath = "C:/files/";
				File f = new File(fileSavePath + thefile);

				multiFile.transferTo(f);

				ret.put("result", "ok");
			} else {
				ret.put("result", "fail");
			}

		} catch (Exception e) {
			ret.put("result", "fail");
			e.printStackTrace();
		}

		return ret;
	}

	public Map name_check(ExtensionVO extensionVO) {
		Map ret = new HashMap();
		try {
			int count = extensionMapper.extension_name_check(extensionVO.getName());
			if (count == 0) {
				ret.put("result", "possible");
			} else {
				ret.put("result", "impossible");
			}
		} catch (Exception e) {
			ret.put("result", "fail");
			e.printStackTrace();
		}
		return ret;
	}
}
