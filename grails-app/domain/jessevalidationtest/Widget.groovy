package jessevalidationtest

class Widget {
    String name
    static hasMany = [allocationItems: AllocationItem]

    User currentUser

    int getTotalHoldPrice() {
        (currentUser.affiliate.territory.hold).setScale(2) * numberOfRooms
    }

    def getNumberOfRooms() {
        return allocationItems.size()
    }

    static constraints = {
    }
}
