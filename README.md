# Compass

Three Types of sensors :

1. Motion Sensors -  measure acceleration forces and rotational forces along three axeslike accelerometers, gravity sensors, gyroscopes, and rotational vector sensors.
2. position Sensors -  environmental parameters, such as ambient air temperature and pressure, illumination, and humidity. This category includes barometers, photometers, and thermometers.
3. environment Sensors-   measure the physical position of a device like  orientation sensors and magnetometers.

Magnetometer to sense directions. sompass uses this sensor
In game applications, sensors are majorly used

Motion and position sensors gives multi-dimensional sensor values
Environmental sensors provides single sensor values

Implementation

1. Add image, rotational Degree text
2. Give feature
 <uses-feature android:name="android.hardware.sensor.accelerometer" android:required="true">
    </uses-feature>
3. When you are suing Sensors, you need to implement SensorEventListener interface,
then you need to implement methods of the interface
4. Need to create an object of Sensor Manager Class and sensor (instance of sensorManager use official doc)
5. Initialize the both 
	sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
            sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

6. Initialize image and rotation text from Design XML
7. Resgister a sensor listener in the onResume() and unregister in onpause()
8. Most imp method





