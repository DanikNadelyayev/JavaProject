package com.project.controllers;

import com.project.models.OilRig;
import com.project.service.OilRigService;
import com.project.storage.SaveOilRigStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class OilRigController {

    private final OilRigService oilRigService;

    private final SaveOilRigStorage saveOilRigService;

    @Autowired
    public OilRigController(OilRigService oilRigService, SaveOilRigStorage saveOilRigService) {
        this.oilRigService = oilRigService;
        this.saveOilRigService = saveOilRigService;

    }

    @PostMapping("/OilRigs/save")
    public void saveOilRigToFile() throws IOException {
        saveOilRigService.saveOilRigToFile();
    }

    @PostMapping("/OilRig")
    public void createOilRig(@RequestBody OilRig oilRig) {
        oilRigService.addOilRig(oilRig);
    }

    @PostMapping("/OilRigs")
    public void createOilRig(@RequestBody List<OilRig> oilRig) {
        oilRigService.addOilRig(oilRig);
    }

    @GetMapping("/OilRigs")
    public List<OilRig> oilRigMap() {
        return oilRigService.getAllOilRigs();
    }

    @GetMapping("/OilRigs/{id}")
    public OilRig getId(@PathVariable int id) {
        return oilRigService.getById(id);
    }

    @DeleteMapping("/OilRigs/{id}")
    public void deleteById(@PathVariable int id) {
        oilRigService.deleteOilRig(id);
    }

    @PutMapping("/OilRigs/{id}")
    public void update(@RequestBody OilRig oilRig, @PathVariable int id) {
        oilRigService.update(oilRig, id);
    }
}

