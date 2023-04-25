package com.atg.kogas.repository;

import com.atg.kogas.domain.FacilityBaseInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityBaseInfoRepository extends JpaRepository<FacilityBaseInfo, Long> {
        FacilityBaseInfo findFacilityBaseInfoByInfoSeq(Long id);
        List<FacilityBaseInfo> findFacilityBaseInfoByInvenName(String invenName);
        //5개 고른경우
        Page<FacilityBaseInfo> findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCode(String invenName, String locateName, String facilityName, String installName, String facilityCode, Pageable pageable);
        //1개만 고른경우
        Page<FacilityBaseInfo> findFacilityBaseInfoByInvenNameOrLocateNameOrFacilityNameOrInstallNameOrFacilityCode(String invenName, String locateName, String facilityName, String installName, String facilityCode, Pageable pageable);

        //엑셀업로드 시 구별할 컬럼 묶기 . 중복값 제거 // 기지명.위치.설비명.설치형태.설비코드.제작사
        FacilityBaseInfo findFacilityBaseInfoByInvenNameAndLocateNameAndFacilityNameAndInstallNameAndFacilityCodeAndProducer(String invenName, String locateName,String facilityName, String installName, String facilityCode, String Producer);

}
