package seedu.address.ui.displayCards;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.model.order.Food;
import seedu.address.model.order.Order;
import seedu.address.ui.UiPart;

public class OrderDisplayListCard extends UiPart<Region> {
    private static final String FXML = "displayCards/OrderDisplayListCard.fxml";
    private static final String NAME_LABEL_FORMAT = "Contact: %1$s (%2$s)";
    private static final String FOOD_LABEL_FORMAT = "Order: %s";

    public final Order order;

    @FXML
    private Label address;
    @FXML
    private Label name;
    @FXML
    private Label food;

    public OrderDisplayListCard(Order order) {
        super(FXML);
        this.order = order;
        address.setText(order.getAddress().toString());
        name.setText(String.format(NAME_LABEL_FORMAT, order.getName().fullName, order.getPhone().toString()));

        StringBuilder sb = new StringBuilder();
        for (Food food : order.getFood()) {
            sb.append(food.foodName + ", ");
        }

        food.setText(String.format(FOOD_LABEL_FORMAT, sb.toString()));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof OrderDisplayListCard)) {
            return false;
        }

        // state check
        OrderDisplayListCard card = (OrderDisplayListCard) other;
        return order.equals(card.order);
    }
}
