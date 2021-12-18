package jessevalidationtest

import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class WidgetServiceSpec extends Specification implements ServiceUnitTest<WidgetService>, DataTest {

    void setupSpec() {
        mockDomain Widget
    }

    void "test something"() {
        setup:
        def territory = new Territory(hold: 704)
        def affiliate = new Affiliate(territory: territory)
        def user = new User(affiliate: affiliate)
        new Widget(name: 'Jeff', currentUser: user)
                .addToAllocationItems([:])
                .addToAllocationItems([:])
                .addToAllocationItems([:])
                .save(failOnError: true)

        when: 'a widget has 3 allocation items and a territory.hold of 704'
        int price = service.getTotalHoldPriceForWidget('Jeff')

        then: 'the total hold price should be 2112'
        price == 2112
    }
}
