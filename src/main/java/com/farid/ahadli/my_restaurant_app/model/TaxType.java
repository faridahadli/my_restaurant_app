package com.farid.ahadli.my_restaurant_app.model;

public enum TaxType {
    VAT(0.18),
    TAX_FREE(0.0);
    Double taxRate;
    TaxType(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxRate(  ) {
        return taxRate;
    }
    public Double calculateTaxAmount(Double price) {
        return price * taxRate;
    }

}
