package pl.sda.covidvavapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.covidvavapp.api.model.*;
import pl.sda.covidvavapp.repository.PatientEntity;
import pl.sda.covidvavapp.repository.PatientRepository;
import pl.sda.covidvavapp.repository.VaccinationEntity;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;

    public void registerPatient(NewPatient newPatient) {
        PatientEntity entity = PatientEntity.builder()
                .firstName(newPatient.getFirstName())
                .lastName(newPatient.getLastName())
                .pesel(newPatient.getPesel())
                .vaccinations(new HashSet<>())
                .build();
        patientRepository.create(entity);
    }

    public void updatePatient(NewPatient updatePatient) {
        patientRepository.getById(updatePatient.getId())
                .map(pat -> pat.updatePatient(updatePatient.getFirstName(), updatePatient.getLastName(), updatePatient.getPesel()))
                .orElseThrow(() -> new IllegalStateException("Patient doesn't exist"));
    }

    public Patient getPatient(Long id) {
        return patientRepository.getById(id)
                .map(this::mapToPatient)
                .orElseThrow(() -> new IllegalStateException("Patient doesn't exist"));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getAll()
                .stream()
                .map(this::mapToPatient)
                .collect(Collectors.toList());
    }

    public Object deletePatient(Long id) {
        patientRepository.delete(id);
        return null;
    }
    public Object deleteVaccination(Long id) {
        patientRepository.deleteVaccination(id);
        return null;
    }

    private Patient mapToPatient(PatientEntity entity) {
        return Patient.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .pesel(entity.getPesel())
                .plannedVacs(entity.getVaccinations().stream()
                        .filter(vac -> !vac.isDone())
                        .map(vac -> new Vaccination(vac.getDate(), vac.getAddress(), vac.getVacType()))
                        .collect(Collectors.toList()))
                .doneVacs(entity.getVaccinations().stream()
                        .filter(VaccinationEntity::isDone)
                        .map(vac -> new Vaccination(vac.getDate(), vac.getAddress(), vac.getVacType()))
                        .collect(Collectors.toList()))
                .build();
    }
}
