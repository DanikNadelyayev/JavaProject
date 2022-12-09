package com.project.storage;

import com.project.models.OilRig;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class OilRigStorage {
    Map<Integer, OilRig> oilRigMap = new HashMap<Integer, OilRig>();

    public void add(OilRig oilRig) {
        oilRigMap.put(oilRig.getId(), oilRig);
    }

    public Set<Map.Entry<Integer, OilRig>> getAllInfo() {
        return oilRigMap.entrySet();
    }

    public OilRig getById(int id) {
        if (oilRigMap.containsKey(id)) {
            return oilRigMap.get(id);
        }
        return oilRigMap.get(id);
    }


}
