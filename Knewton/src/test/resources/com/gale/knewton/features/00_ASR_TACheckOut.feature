Feature: Validate ASR Cancle and ASR Close Checkout tickets
  
  User should able to create ASR ticket and able to close and Cancle that

  @ASRCancle
  Scenario Outline: Use should able to create and Cancle ticket
    Given I created ticket in VFO with URL <VFO_URL>
    And Created service order in Remedy with URL <Remedy_URL>
    When I Cancle ticket in VFO
    Then I should be able to see the status  in VNET with URL <VNet_URL>

    Examples: 
      | VFO_URL                              | Remedy_URL                                                   | VNet_URL                                             |
      | http://vfoinfwlacv01.corp.pvt:13002/ | http://reminfwlacv01.corp.pvt/arsys/shared/login.jsp?/arsys/ | http://vntinfwsacl01.corp.pvt/sh/servlet/PortalLogin |
