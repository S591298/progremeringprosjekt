package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.util.Locale;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		// TODO - START
		double min;
		min = da[0];
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

		// TODO - SLUT

	

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		double[] latitudes = new double [gpspoints.length];
		for (int i = 0; i <gpspoints.length;i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}
		return latitudes;

		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] longitudes = new double [gpspoints.length];
		for (int i = 0; i <gpspoints.length;i++) {
			 longitudes[i] = gpspoints[i].getLongitude();
		}
		return longitudes;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double latitudesum = latitude2 - latitude1;
		double longitudesum = longitude2 - longitude1;
		
		double lat =  Math.sin(latitudesum/2);
		double lon =  Math.sin(longitudesum/2);
		
		double a = lat*lat + Math.cos(latitude1)*Math.cos(latitude2)*lon*lon;
		double c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
		d = R*c;
		
		return d;
		
		
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		

		// TODO - START
		double distance = distance(gpspoint1,gpspoint2);
		int sec1 = gpspoint1.getTime();
		int sec2 = gpspoint2.getTime();
		secs = sec2 - sec1;
		
		speed = (distance/secs)*3.6;
		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		// TODO - START
		int hh = secs / 3600;
		int mm = secs % 3600 / 60;
		int ss = secs % 60;
		
		return String.format("  %02d:%02d:%02d", hh, mm, ss);

		
		// TODO - SLUTT

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		// TODO - START
		str = String.format(Locale.US, "%.2f", d);
		String str2 = String.format("%10s", str);
		return str2;

		// TODO - SLUTT
		
	}
}
