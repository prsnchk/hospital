package com.solvd.hospital.laboratory;

public class PrintAnAnalysisLaboratory implements Analysis {

    @Override
    public void createAnalysesList() { System.out.println("The specialist print analyses list for patient.");
    }

    @Override
    public void canselAnalysesList() { System.out.println("The specialist cansel print analyses list for patient.");
    }

    @Override
    public void editAnalysesList() { System.out.println("The specialist edit analyses list for patient.");
    }

    public void eatprintAnalyseslist() {
        System.out.println("The person eat analyses list for patient");
    }
}
