/**
 * This class keeps shipment data and methots.
 */
public class Shipment {
    private int shipmentId;
    private String sender;
    private String receiver;
    private String status;
    private String address;
    static int id=0;

    /**
     * @param sender Sender
     * @param receiver Receiver
     * @param status Status
     * @param address Address
     */
    public Shipment(String sender, String receiver, String status, String address) {
        this.sender = sender;
        this.receiver = receiver;
        this.status =status;
        this.address = address;
        this.shipmentId=++id;
    }

    /**
     * @return Returns sender of shipments.
     */
    public String getSender() {
        return sender;
    }

    /**
     * Changes sender of shipment
     * @param sender Sender
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return Returns receiver of shipment.
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     *Changes receiver of shipment.
     * @param receiver Receiver
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return Returns Adress of shipment.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Changes adress of shipment.
     * @param address Adress
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Returns status of shipment.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Changes status of shipment.
     * @param status Status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Prints information of shipment.
     */
    public void printDetails() {
        System.out.println("Sender: " + sender);
        System.out.println("Receiver: " + receiver);
        System.out.println("Address: " + address);
        System.out.println("Status: " + status);
    }

    /**
     * @return Returns id of shipment.
     */
    public int getShipmentId() {
        return shipmentId;
    }
}
