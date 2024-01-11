import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';

interface Faq {
  question: string;
  answer: string;
  showAnswer: boolean;
}

@Component({
  selector: 'app-customer-service',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './customer-service.component.html',
  styleUrl: './customer-service.component.scss'
})
export class CustomerServiceComponent {
  faqs: Faq[] = [
    { 
      question: 'Jaki jest zakres cen mebli?', 
      answer: 'Zakres cen naszych mebli jest bardzo zróżnicowany i zależy od wielu czynników, takich jak materiał, design i dodatkowe funkcje. Możesz znaleźć produkty dostosowane do różnych budżetów, zaczynając od bardziej przystępnych cen, aż do ekskluzywnych kolekcji.' ,
      showAnswer: false 
    },
    { 
      question: 'Czy oferujecie usługi dostawy i montażu?', 
      answer: 'Tak, świadczymy kompleksowe usługi dostawy i montażu. Po dokonaniu zakupu, nasi specjaliści ds. logistyki skontaktują się z Tobą, aby ustalić dogodny termin dostawy. Nasz zespół montażowy profesjonalnie zainstaluje meble w wybranym miejscu w Twoim domu.' ,
      showAnswer: false 
    },
    { 
      question: 'Jakie są dostępne formy płatności?', 
      answer: 'Akceptujemy różne formy płatności, w tym karty kredytowe, przelewy bankowe oraz płatności gotówkowe przy odbiorze towaru. Dodatkowo, oferujemy opcje płatności ratalnych, które mogą być dostosowane do Twoich potrzeb finansowych.' ,
      showAnswer: false 
    },
    { 
      question: 'Czy mogę zwrócić mebel, jeśli mi nie pasuje?', 
      answer: 'Tak, masz prawo do zwrotu produktu w ciągu 14 dni od daty zakupu, zgodnie z naszą polityką zwrotów. Warto pamiętać, że mebel musi być w nienaruszonym stanie, a wszystkie etykiety muszą pozostać na swoim miejscu. Skontaktuj się z naszym biurem obsługi klienta, aby zorganizować zwrot.' ,
      showAnswer: false 
    },
    { 
      question: 'Jak długo trwa dostawa mebli?', 
      answer: 'Czas dostawy zależy od produktu, lokalizacji dostawy oraz dostępności. Standardowo staramy się dostarczyć zamówione meble w ciągu 7-14 dni roboczych. Po złożeniu zamówienia otrzymasz potwierdzenie z przewidywanym terminem dostawy.' ,
      showAnswer: false 
    },
  ];

  toggleAnswer(faq: Faq): void {
    faq.showAnswer = !faq.showAnswer;
  }
}
