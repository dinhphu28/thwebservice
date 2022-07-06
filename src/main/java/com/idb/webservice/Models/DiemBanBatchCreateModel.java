package com.idb.webservice.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiemBanBatchCreateModel {
    private List<DiemBanCreateModel> diemBans;
}
