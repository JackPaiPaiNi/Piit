
/**
 * HwWsControlServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.6  Built on : Aug 30, 2011 (10:00:16 CEST)
 */

    package webservice;

    /**
     *  HwWsControlServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class HwWsControlServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public HwWsControlServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public HwWsControlServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for changPwd method
            * override this method for handling normal response from changPwd operation
            */
           public void receiveResultchangPwd(
                    webservice.HwWsControlServiceStub.ChangPwdResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from changPwd operation
           */
            public void receiveErrorchangPwd(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyUser method
            * override this method for handling normal response from modifyUser operation
            */
           public void receiveResultmodifyUser(
                    webservice.HwWsControlServiceStub.ModifyUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyUser operation
           */
            public void receiveErrormodifyUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for disableUser method
            * override this method for handling normal response from disableUser operation
            */
           public void receiveResultdisableUser(
                    webservice.HwWsControlServiceStub.DisableUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from disableUser operation
           */
            public void receiveErrordisableUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    webservice.HwWsControlServiceStub.AddUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for validateAccount method
            * override this method for handling normal response from validateAccount operation
            */
           public void receiveResultvalidateAccount(
                    webservice.HwWsControlServiceStub.ValidateAccountResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from validateAccount operation
           */
            public void receiveErrorvalidateAccount(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for activeUser method
            * override this method for handling normal response from activeUser operation
            */
           public void receiveResultactiveUser(
                    webservice.HwWsControlServiceStub.ActiveUserResponseE result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from activeUser operation
           */
            public void receiveErroractiveUser(java.lang.Exception e) {
            }
                


    }
    