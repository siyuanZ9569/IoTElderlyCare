package timeCheck;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.regex.Pattern;

public class timeCheckExperience {
	public static void main(String[] args) {
//		int input = 1554226650-1546300800;
//		int days =input/86400;
//		double hours = input % 86400 /3600;
//		double min = ((input % 86400)%3600)/ 60;
//		double seconds = input%86400 %3600 %60;
//		System.out.println("days: "+days+". Hours: "+hours+". Minutes: "+min+". Seconds: "+seconds);
		BigDecimal bd = new BigDecimal( input );
		BigDecimal microsDivisor = new BigDecimal( 1_000_000_000L );
		long seconds = bd.longValue( );
		BigDecimal bdMicros = bd.subtract( new BigDecimal( seconds ) ).multiply( microsDivisor );
		long nanos = bdMicros.longValue( );
		
		Instant instant = Instant.ofEpochSecond( seconds , nanos ) ;
		System.out.println(instant.toString());
		long ut1 = Instant.now().getEpochSecond();
        System.out.println(ut1-ut1%86400);

        long ut2 = System.currentTimeMillis() / 1000L;
        System.out.println(ut2);

        Date now = new Date();
        long ut3 = now.getTime() / 1000L;
        System.out.println(ut3);
	}

}
