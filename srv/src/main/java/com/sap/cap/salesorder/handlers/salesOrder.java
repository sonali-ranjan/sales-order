package com.sap.cap.salesorder.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CdsReadEventContext;
import com.sap.cds.services.cds.CdsService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.On;
import com.sap.cds.services.handler.annotations.ServiceName;

@Component
@ServiceName("salesOrder")
public class salesOrder implements EventHandler {

    private Map<Object, Map<String, Object>> Order = new HashMap<>();

    @On(event = CdsService.EVENT_CREATE, entity = "salesOrder.Order")
    public void onCreate(CdsCreateEventContext context) {
        context.getCqn().entries().forEach(e -> Order.put(e.get("salesOrderSeq"), e));
        context.setResult(context.getCqn().entries());
    }

    @On(event = CdsService.EVENT_READ, entity = "salesOrder.Order")
    public void onRead(CdsReadEventContext context) {
        context.setResult(Order.values());
    }
}
