package model.experiment.base;

public class BaseExperimentModel {
    private int[][] baseAdjacentVer1;
    private int[][] baseAdjacentVer2;
    private int versionNumber;
    private int socketNumber;

    public BaseExperimentModel(int versionNumber, int socketNumber) {
        this.versionNumber = versionNumber;
        this.socketNumber = socketNumber;
    }

    public int[][] getBaseAdjacentVer1() {
        return baseAdjacentVer1;
    }

    public int[][] getBaseAdjacentVer2() {
        return baseAdjacentVer2;
    } 

    public int getVersionNumber() {
        return versionNumber;
    }

    public int getSockerNumber() {
        return socketNumber;
    }
}
