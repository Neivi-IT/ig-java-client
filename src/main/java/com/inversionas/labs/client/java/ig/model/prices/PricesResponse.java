package com.inversionas.labs.client.java.ig.model.prices;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
* List of prices
*/
@Getter
@Setter
public class PricesResponse {

    private List<PricesItem> prices;

    private InstrumentType instrumentType;

    private Metadata metadata;
}
