package com.orange.upro.winfoo.web.pgm;

import java.io.IOException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
 
@Controller
@RequestMapping("/")
public class PgmFileController {
    
    @Autowired
    PgmFileValidator fileValidator;
    
    @InitBinder("pgmFile")
    protected void initBinderFileBucket(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) {
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");
        return "welcome";
    }
    
    @RequestMapping(value="/upload", method = RequestMethod.GET)
    public String getUploadPage(ModelMap model) {
        PgmFile fileModel = new PgmFile();
        model.addAttribute("pgmFile", fileModel);
        return "fileUploader";
    }
 
    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String fileUpload(@Valid PgmFile pgmFile, BindingResult result, ModelMap model) throws IOException {
 
        if (result.hasErrors()) {
            System.out.println("validation errors");
            return "fileUploader";
        } else {            
            System.out.println("Fetching file");
            MultipartFile multipartFile = pgmFile.getFile();
 
            //Now do something with file...
            //FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(UPLOAD_LOCATION + pgmFile.getFile().getOriginalFilename()));
             
            String fileName = multipartFile.getOriginalFilename();
            model.addAttribute("fileName", fileName);
            return "success";
        }
    }
 
}