package model.experiment.base;

public class BaseExperimentModel {
    protected int[][] baseAdjacentVer1;
    protected int[][] baseAdjacentVer2;
    protected int[][] baseAdjacentVer3;
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
    public int[][] getBaseAdjacentVer3() {
        return baseAdjacentVer3;
    } 

    public int getVersionNumber() {
        return versionNumber;
    }

    public int getSockerNumber() {
        return socketNumber;
    }
}
