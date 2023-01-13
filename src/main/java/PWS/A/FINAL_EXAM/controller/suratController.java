/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS.A.FINAL_EXAM.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import PWS.A.FINAL_EXAM.service.suratService;
import PWS.A.FINAL_EXAM.model.entity.Surat;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author MADD
 * Nama : Ahmad Musthafa Masyhur
 * NIM  : 20200140140
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class suratController
{
    @Autowired
    private suratService suratService;

    @GetMapping("/check")
    @ResponseBody
    public String checkAPI(){
        return "connect";
    }

    @PostMapping("/surat")
    public String saveSurat(@RequestBody Surat surat) throws InterruptedException, ExecutionException{
        
        return suratService.save(surat);
        
    }

    @GetMapping("/suratall")
    public List<Surat> viewSuratAll() throws InterruptedException, ExecutionException{
        
        return suratService.getSuratAll();
        
    }

    @GetMapping("/surat/{ID}")
    public Surat viewSurat(@PathVariable String ID) throws InterruptedException, ExecutionException{
        
        return suratService.getSurat(ID);
        
    }

    @PutMapping("/surat")
    public String updateSurat(@RequestBody Surat surat) throws InterruptedException, ExecutionException
    {
        return suratService.update(surat);
        
    }

    @DeleteMapping("/surat/{ID}")
    public String deleteSurat(@PathVariable String ID) throws InterruptedException, ExecutionException{
        
        return suratService.delete(ID);
        
    }
    
}
