package sjht.erp.workinfo.service;

import sjht.erp.workinfo.dto.request.HolidayRequestDto;
import sjht.erp.workinfo.dto.request.UpdateHolidayRequestDto;
import sjht.erp.workinfo.dto.request.UpdateMyHolidayRequestDto;

public interface HolidayRegistryService {
    boolean insert(HolidayRequestDto holidayRequestDto);
    boolean updateHoliday(UpdateHolidayRequestDto updateHolidayRequestDto);
    boolean updateMyHoliday(UpdateMyHolidayRequestDto updateMyHolidayRequestDto);
    boolean deleteMyHoliday(int tano);
}
