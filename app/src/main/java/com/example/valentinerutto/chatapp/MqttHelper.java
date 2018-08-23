package com.example.valentinerutto.chatapp;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.DisconnectedBufferOptions;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

public class MqttHelper implements IMqttActionListener {
    MqttAndroidClient mqttAndroidClient;
        final String serverUri = "tcp://broker.hivemq.com:1883";

        final String clientID ;
        final String subscriptionTopic = "office";

        final String username = "";
        final String password = "";


        public MqttHelper(Context context){
            clientID = MqttClient.generateClientId();

            mqttAndroidClient = new MqttAndroidClient(context, serverUri, clientID);
            mqttAndroidClient.setCallback(new MqttCallbackExtended() {
                @Override
                public void connectComplete(boolean b, String s) {
                    Log.w("mqtt", s);
                }

                @Override
                public void connectionLost(Throwable throwable) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                    Log.w("Mqtt", mqttMessage.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

                }
            });
            connect();
        }

        public void setCallback(MqttCallbackExtended callback) {
            mqttAndroidClient.setCallback(callback);
        }

        private void connect(){
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setAutomaticReconnect(true);
            mqttConnectOptions.setCleanSession(false);
            mqttConnectOptions.setUserName(username);
            mqttConnectOptions.setPassword(password.toCharArray());

            try {

                mqttAndroidClient.connect(mqttConnectOptions, null, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {

                        DisconnectedBufferOptions disconnectedBufferOptions = new DisconnectedBufferOptions();
                        disconnectedBufferOptions.setBufferEnabled(true);
                        disconnectedBufferOptions.setBufferSize(100);
                        disconnectedBufferOptions.setPersistBuffer(false);
                        disconnectedBufferOptions.setDeleteOldestMessages(false);

                        mqttAndroidClient.setBufferOpts(disconnectedBufferOptions);

                        subscribeToTopic();
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        Log.w("Mqtt", "Failed to connect to: " + serverUri + exception.toString());
                    }
                });


            } catch (MqttException ex){
                ex.printStackTrace();
            }
        }

    public void sendMessage(String message) {
        String topic = subscriptionTopic;
        String textToSend = message;
        int qos = 2;

        boolean retained = false;

        String[] args = new String[2];
        args[0] = textToSend;
        args[1] = topic+";qos:"+qos+";retained:"+retained;

        try {
            mqttAndroidClient.publish(topic, textToSend.getBytes(), qos, retained, null, this);
        }
        catch (MqttSecurityException e) {
            e.printStackTrace();
        }
        catch (MqttException e) {
            e.printStackTrace();
        }
    }



    private void subscribeToTopic() {
            try {
                mqttAndroidClient.subscribe(subscriptionTopic, 0, null, new IMqttActionListener() {
                    @Override
                    public void onSuccess(IMqttToken asyncActionToken) {
                        Log.w("Mqtt","Subscribed!");
                    }

                    @Override
                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                        Log.w("Mqtt", "Subscribed fail!");
                    }
                });

            } catch (MqttException ex) {
                System.err.println("Exceptionst subscribing");
                ex.printStackTrace();
            }
        }

    @Override
    public void onSuccess(IMqttToken asyncActionToken) {

    }

    @Override
    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {

    }
}


