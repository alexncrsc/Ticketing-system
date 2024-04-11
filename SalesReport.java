import java.util.HashMap;
import java.util.Map;

public class SalesReport {
    private Map<Event, Integer> eventSalesMap;

    public SalesReport() {
        this.eventSalesMap = new HashMap<>();
    }

    // Metoda pentru adăugarea unei vânzări de bilete pentru un anumit eveniment
    public void addEventSale(Event event, int numberOfTicketsSold) {
        eventSalesMap.put(event, numberOfTicketsSold);
    }

    // Metodă pentru generarea raportului de vânzări
    public void generateReport() {
        System.out.println("Sales Report:");
        for (Event event : eventSalesMap.keySet()) {
            int ticketsSold = eventSalesMap.get(event);
            System.out.println("Event: " + event.getName() + ", Tickets Sold: " + ticketsSold);
        }
    }
}
