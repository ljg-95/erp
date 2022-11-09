package sjht.erp.workinfo.repository;

import org.apache.ibatis.annotations.Mapper;
import sjht.erp.workinfo.dto.request.HolidayRequestDto;
import sjht.erp.workinfo.dto.request.UpdateHolidayRequestDto;
import sjht.erp.workinfo.dto.request.UpdateMyHolidayRequestDto;

@Mapper
public interface HolidayRegistryMapper {
    int insertHoliday(HolidayRequestDto holidayRequestDto);
    int updateHoliday(UpdateHolidayRequestDto updateHolidayRequestDto);
    int updateMyHoliday(UpdateMyHolidayRequestDto updateMyHolidayRequestDto);
    int deleteMyHoliday(int tano);
}
