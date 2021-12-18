package jessevalidationtest

import grails.gorm.transactions.Transactional

@Transactional
class WidgetService {

    int getTotalHoldPriceForWidget(String name) {
        Widget w = Widget.find { name == name }
        w.totalHoldPrice
    }
}
