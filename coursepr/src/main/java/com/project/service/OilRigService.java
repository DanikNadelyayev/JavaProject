package com.project.service;

import com.project.models.OilRig;
import com.project.storage.OilRigStorage;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OilRigService {
    private int oilRigId = 0;
    private final HashMap<Integer, OilRig> oilRigStorageService = new HashMap<>();

    public List<OilRig> getAllOilRigs() {
        return new LinkedList<>(this.oilRigStorageService.values());
    }

    public OilRig getById(int id) {
        return oilRigStorageService.getOrDefault(id, null);
    }

    public void deleteOilRig(int id) {
        if (oilRigStorageService.containsKey(id)) {
            this.oilRigStorageService.remove(id);
        }
    }

    public OilRig addOilRig (OilRig oilRig) {
        try {
            oilRigId++;
            oilRig.setId(oilRigId);
            oilRigStorageService.put(oilRig.getId(), oilRig);
            return oilRig;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public List<OilRig> addOilRig (List<OilRig> oilRig) {
        List<OilRig> oilRigs = new ArrayList<>();
        for (OilRig oilRig1: oilRig) {
            oilRigId++;
            oilRig1.setId(oilRigId);
            oilRigStorageService.put(oilRig1.getId(), oilRig1);
            oilRigs.add(oilRig1);
        }
        return oilRigs;
    }

    public void update(OilRig oilRig, int id) {
        if (oilRigStorageService.containsKey(oilRig.getId())) {
            try {
                this.oilRigStorageService.remove(id);
                oilRigStorageService.put(id, oilRig);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
