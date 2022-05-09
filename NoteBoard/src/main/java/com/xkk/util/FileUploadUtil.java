package com.xkk.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

public class FileUploadUtil {
    public static Map<String, String> upload(HttpServletRequest request, String filepath) {
        if (ServletFileUpload.isMultipartContent(request)) {

            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload sfu = new ServletFileUpload(factory);
                sfu.setSizeMax(10 * 1024 * 1024);
                sfu.setHeaderEncoding("utf-8");
                List<FileItem> fileItemList = sfu.parseRequest(request);
                Iterator<FileItem> fileItems = fileItemList.iterator();
                Map<String, String> map = new TreeMap<String, String>();

                while ((fileItems.hasNext())) {
                    FileItem fileItem = fileItems.next();
                    try {
                        if (fileItem.isFormField()) {
                            String name = fileItem.getFieldName();
                            String value = fileItem.getString("utf-8");
                            map.put(name, value);
                        } else {
                            if (fileItem.getName() == null || fileItem.getFieldName() == null) {
                                map.put("fileName", "empty");
                                map.put("newFileName", "empty");
                            } else {
                                String fileName = fileItem.getName();
                                System.out.println("原文件名：" + fileName);
                                String suffix = fileName.substring(fileName.lastIndexOf('.'));
                                System.out.println("扩展名：" + suffix);
                                String newFileName = System.currentTimeMillis() + suffix;
                                System.out.println("新文件名：" + newFileName);
                                map.put("fileName", fileName);
                                map.put("newFileName", newFileName);
                                String context = filepath + newFileName;
                                System.out.println("图片的路径为" + context);
                                File file = new File(context);
                                System.out.println(file.getAbsolutePath());
                                fileItem.write(file);
                                if (!fileName.contains("empty") || !newFileName.contains("empty")) {
                                    fileItem.delete();
                                }

                            }

                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("出现异常");
                        map.put("fileName", "empty");
                        map.put("newFileName", "empty");
                        e.printStackTrace();
                    }

                }
                return map;
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
