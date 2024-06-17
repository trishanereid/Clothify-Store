package edu.icet.bo;

import edu.icet.util.BoType;

import static edu.icet.util.BoType.CUSTOMER;

public class BoFactory {
    private static BoFactory instance;

    private BoFactory(){}
    public static BoFactory getInstance(){
        return instance != null ? instance:(instance = new BoFactory());
    }

//    public <T extends SuperBo>T getBo(BoType type){
//        switch (type){
//            case CUSTOMER:return (T) new CustemerBoImpl();
//        }
//        return null;
//    }
}
