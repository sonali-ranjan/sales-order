service salesOrder {
    entity Order {
        key salesOrderSeq : Integer;
        key orderId : Integer;
        modelSeq : Integer;
        businessUnit {
            businessUnitSeq : Integer;
            name : String;
        }
    }
}
