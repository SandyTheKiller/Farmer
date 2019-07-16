package com.yoga.farmer.model;

public class ModelFeilds {
    public String farmArea;
    public String farmName;
    public String subCropName;
    public int drawable;
    public String color;

    public ModelFeilds(String farmName,String farmArea,String subCropName, int d, String c )
    {
        this.farmName=farmName;
        this.farmArea=farmArea;
        this.subCropName=subCropName;
        drawable=d;
        color=c;
    }
}
