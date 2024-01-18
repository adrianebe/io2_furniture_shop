import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export function passwordMatchValidator(): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const passwordFirst = control.get('passwordFirst');
    const passwordSec = control.get('passwordSec');

    if (!passwordFirst || !passwordSec) {
      return null;  // Brak błędów, jeżeli pola nie istnieją
    }

    const passwordFirstValue = passwordFirst.value as string;
    const passwordSecValue = passwordSec.value as string;

    if (passwordFirstValue !== passwordSecValue) {
      return { passwordMatch: true };  // Błąd, jeżeli hasła nie są identyczne
    }

    return null;  // Brak błędów, jeżeli hasła są identyczne
  };
}
