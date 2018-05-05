package Logic;

public class Movement {

    private int startNodeID, endNodeID, startSecond, endSecond;

    public Movement(int pStartNode, int pEndNode, int pStartSecond, int pEndSecond) {
        startNodeID = pStartNode;
        endNodeID = pEndNode;
        startSecond = pStartSecond;
        endSecond = pEndSecond;
    }

    public int getStartNodeID() {
        return startNodeID;
    }

    public int getEndNodeID() {
        return endNodeID;
    }

    public int getStartSecond() {
        return startSecond;
    }

    public int getEndSecond() {
        return endSecond;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.startNodeID;
        hash = 13 * hash + this.endNodeID;
        hash = 13 * hash + this.startSecond;
        hash = 13 * hash + this.endSecond;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movement other = (Movement) obj;
        if (this.startNodeID != other.startNodeID) {
            return false;
        }
        if (this.endNodeID != other.endNodeID) {
            return false;
        }
        if (this.startSecond != other.startSecond) {
            return false;
        }
        if (this.endSecond != other.endSecond) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + startSecond + "-" + endSecond + ']';
    }

}
