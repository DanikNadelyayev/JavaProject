package com.project;

import com.project.models.OilRig;
import com.project.storage.OilRigStorage;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OilRigStorageTest {
    List<OilRig> oilRigList = new LinkedList<>();
    OilRigStorage oilRigStorage = new OilRigStorage();

    @Before
    void setOilRigList() {
        OilRig statfjordBPlatform = new OilRig(1, "Statfjord B Platform", "61°14'09.2", 250000f, 40, "5.6.2022");
        OilRig equinor = new OilRig(2, "Equinor", "61 ° 15'20", 70000f, 80, "14.6.2022");

        oilRigList.add(statfjordBPlatform);
        oilRigList.add(equinor);
    }

    @Test
    void saveOilRigToCsvTest() throws IOException {
        File file = new File("2022-04-07-OilRig.csv");

        if (!file.exists()) {
            file.createNewFile();
        }

        OutputStreamWriter writer = new OutputStreamWriter
                (new FileOutputStream(file), StandardCharsets.UTF_8);
        for (OilRig oilRig : oilRigList) {
            writer.write(oilRig.toCSV() + "\n");

            PrintWriter printWriter;
            printWriter = new PrintWriter(file);
            printWriter.println
                    ("Name,Coordinates,Production-Per-Day,Filling-of-Tanks,ID,Date-of-Shipment (from Date-of-Shipment)");
            printWriter.println
                    ("Statfjord B Platform,61°1409.2N 1°55,250,000 barrels ,40%, 1, 5.6.2022, 9.6.2022, 7.6.2022");
            printWriter.println
                    ("Wintershall,\"54 ° 01′33  \",\"18,100 barrels\",55%,\"Tanker 3,Tanker 3\",\"1.6.2022, 10.6.2022\"");
        }
    }
}