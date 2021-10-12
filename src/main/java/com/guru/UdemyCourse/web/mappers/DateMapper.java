package com.guru.UdemyCourse.web.mappers;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 *Se agrega esta clase debido a la diferencia de las variables
 * DATE de Beer y BeerDto ya que si se dejaran sin la logica
 * de esta clase tronaria debido al @Mapper
 */
@Component // es necesaria esta anotacion
public class DateMapper {

    public OffsetDateTime asOffsetDateTime (Timestamp ts){
        if(ts!=null) return  OffsetDateTime.of(ts.toLocalDateTime().getYear(),ts.toLocalDateTime().getMonthValue(),
                    ts.toLocalDateTime().getMonthValue(),ts.toLocalDateTime().getHour(),ts.toLocalDateTime().getMinute(),
                    ts.toLocalDateTime().getSecond(),ts.toLocalDateTime().getNano(), ZoneOffset.UTC);
        return null;
    }

    public Timestamp asTimestamp(OffsetDateTime offsetDateTime){
        if (offsetDateTime!= null) return Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
        return null;
    }
}