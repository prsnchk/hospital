package com.solvd.hospital.laboratory;

public class TakeAnAnalysisLaboratory implements Analysis {
    @Override
    public void createAnalysesList() { System.out.println("The specialist creates analyses list for patient.");
    }
    @Override
    public void canselAnalysesList() { System.out.println("The specialist cansel analyses list for patient.");
    }
    @Override
    public void editAnalysesList() { System.out.println("The specialist edit analyses list for patient.");

    }
    public void checkAnalyses() {
        System.out.println("The specialist checks analyses for patient");
    }
    public void eatAnalyses() {
        System.out.println("The specialist eat analyses for patient");
    }
}
