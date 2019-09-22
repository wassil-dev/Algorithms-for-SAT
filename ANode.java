import java.util.List;

public abstract class ANode implements Comparable {

  ANode pathParent;
  float costFromStart;
  float estimatedCostToGoal;


  public float getCost() {
    return costFromStart + estimatedCostToGoal;
  }


  public int compareTo(Object other) {
    float thisValue = this.getCost();
    float otherValue = ((ANode)other).getCost();

    float v = thisValue - otherValue;
    return (v>0)?1:(v<0)?-1:0; // sign function
  }


  /**
    Gets the cost between this node and the specified
    adjacent (AKA "neighbor" or "child") node.
  */
  public abstract float getCost(ANode node);


  /**
    Gets the estimated cost between this node and the
    specified node. The estimated cost should never exceed
    the true cost. The better the estimate, the more
    effecient the search.
  */
  public abstract float getEstimatedCost(ANode node);


  /**
    Gets the children (AKA "neighbors" or "adjacent nodes")
    of this node.
  */
  public abstract List getNeighbors();
}  