package com.project.storage;

import com.project.models.OilRig;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class SaveOilRigStorage implements SaveOilRigStorageInterface {

    private HashMap<Integer, OilRig> oilRigHashMap = new HashMap<>();

    @Override
    public void saveOilRigToFile() throws IOException {
        List<OilRig> oilRigs = new ArrayList<>(oilRigHashMap.values());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        File file = new File(formatter.format(date) + ".csv");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
        writer.write(OilRig.getHeaders() + "\n");
        for (OilRig oilRig : oilRigs) {
            if (file.exists()) {
                try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath(), true)) {
                    fileWriter.write(oilRig.toCSV());
                    fileWriter.write(System.lineSeparator());
                } catch (IOException e) {
                    System.out.println(e);

                }

            } else {
                try (FileWriter fileWriter = new FileWriter(file.getAbsolutePath())) {
                    fileWriter.write("name, coordinates, amount of production per day, filling of tanks" + System.lineSeparator());
                    fileWriter.write(oilRig.toCSV());
                    fileWriter.write(System.lineSeparator());
                } catch (IOException e) {
                    System.out.println(e);
                }
                writer.close();

            }
        }
    }
}


