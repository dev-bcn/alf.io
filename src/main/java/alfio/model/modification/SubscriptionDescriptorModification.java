/**
 * This file is part of alf.io.
 *
 * alf.io is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * alf.io is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with alf.io.  If not, see <http://www.gnu.org/licenses/>.
 */
package alfio.model.modification;

import alfio.model.PriceContainer.VatStatus;
import alfio.model.SubscriptionDescriptor.SubscriptionTimeUnit;
import alfio.model.SubscriptionDescriptor.SubscriptionUsageType;
import alfio.model.SubscriptionDescriptor.SubscriptionValidityType;
import alfio.util.MonetaryUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
public class SubscriptionDescriptorModification {
    private final UUID id;
    private final Map<String, String> title;
    private final Map<String, String> description;
    private final Integer maxAvailable;
    private final ZonedDateTime onSaleFrom;
    private final ZonedDateTime onSaleTo;
    private final BigDecimal price;
    private final BigDecimal vat;
    private final VatStatus vatStatus;
    private final String currency;
    private final Boolean isPublic;
    private final int organizationId;

    private final Integer maxEntries;
    private final SubscriptionValidityType validityType;
    private final SubscriptionTimeUnit validityTimeUnit;
    private final Integer validityUnits;
    private final ZonedDateTime validityFrom;
    private final ZonedDateTime validityTo;
    private final SubscriptionUsageType usageType;

    public SubscriptionDescriptorModification(@JsonProperty("id") UUID id,
                                              @JsonProperty("title") Map<String, String> title,
                                              @JsonProperty("description") Map<String, String> description,
                                              @JsonProperty("maxAvailable") Integer maxAvailable,
                                              @JsonProperty("onSaleFrom") ZonedDateTime onSaleFrom,
                                              @JsonProperty("onSaleTo") ZonedDateTime onSaleTo,
                                              @JsonProperty("price") BigDecimal price,
                                              @JsonProperty("vat") BigDecimal vat,
                                              @JsonProperty("vatStatus") VatStatus vatStatus,
                                              @JsonProperty("currency") String currency,
                                              @JsonProperty("isPublic") Boolean isPublic,
                                              @JsonProperty("organizationId") int organizationId,
                                              @JsonProperty("maxEntries") Integer maxEntries,
                                              @JsonProperty("validityType") SubscriptionValidityType validityType,
                                              @JsonProperty("validityTimeUnit") SubscriptionTimeUnit validityTimeUnit,
                                              @JsonProperty("validityUnits") Integer validityUnits,
                                              @JsonProperty("validityFrom") ZonedDateTime validityFrom,
                                              @JsonProperty("validityTo") ZonedDateTime validityTo,
                                              @JsonProperty("usageType") SubscriptionUsageType usageType) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.maxAvailable = maxAvailable;
        this.onSaleFrom = onSaleFrom;
        this.onSaleTo = onSaleTo;
        this.price = price;
        this.vat = vat;
        this.vatStatus = vatStatus;
        this.currency = currency;
        this.isPublic = isPublic;
        this.organizationId = organizationId;
        this.maxEntries = maxEntries;
        this.validityType = validityType;
        this.validityTimeUnit = validityTimeUnit;
        this.validityUnits = validityUnits;
        this.validityFrom = validityFrom;
        this.validityTo = validityTo;
        this.usageType = usageType;
    }

    public int getPriceCts() {
        return MonetaryUtil.unitToCents(price, currency);
    }
}