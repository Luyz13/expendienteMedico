package com.levm.expendienteMedico.Service;

import java.util.List;
import java.util.Optional;

import com.levm.expendienteMedico.entity.SignoVital;

public interface ISignoVitalService {
	List<SignoVital> getAll();
	
	Optional<SignoVital> getById(int idSigno);
	
	void delete(SignoVital signo);
	
	void create(SignoVital signo);
	
	void update(int idSigno,SignoVital signo);
}
