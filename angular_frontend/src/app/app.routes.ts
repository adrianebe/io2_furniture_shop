import { Routes } from '@angular/router';
import { BathroomComponent } from './bathroom/bathroom.component';
import { BedroomComponent } from './bedroom/bedroom.component';
import { KitchenComponent } from './kitchen/kitchen.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LivingRoomComponent } from './living-room/living-room.component';
import { ContactComponent } from './contact/contact.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';
import { BoardsComponent } from './boards/boards.component';

export const routes: Routes = [{path: 'bathroom', component: BathroomComponent},
{path: 'bedroom', component: BedroomComponent},
{path: 'kitchen', component: KitchenComponent},
{path: 'living_room', component: LivingRoomComponent},
{path: 'boards', component: BoardsComponent},
{path: 'login', component: LoginComponent},
{path: 'register', component: RegisterComponent},
{path: 'contact', component: ContactComponent},
{path: 'customer_service', component: CustomerServiceComponent}];


