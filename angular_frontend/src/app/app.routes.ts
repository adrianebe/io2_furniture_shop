import { Routes } from '@angular/router';
import { BathroomComponent } from './bathroom/bathroom.component';
import { BedroomComponent } from './bedroom/bedroom.component';
import { KitchenComponent } from './kitchen/kitchen.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LivingRoomComponent } from './living-room/living-room.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';
import { BoardsComponent } from './boards/boards.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { ForgetPasswordComponent } from './forget-password/forget-password.component';
import { OrdersComponent } from './orders/orders.component';
import { ComplaintsComponent } from './complaints/complaints.component';
import { AdminCrudAddComponent } from './admin-crud-add/admin-crud-add.component';
import { AdminCrudEditComponent } from './admin-crud-edit/admin-crud-edit.component';
import { AdminCrudComponent } from './admin-crud/admin-crud.component';
import { StatuteComponent } from './statute/statute.component';
import { DetailProductComponent } from './detail-product/detail-product.component';
import { EditProductComponent } from './edit-product/edit-product.component';

export const routes: Routes = [{path: '', component: HomeComponent},
{path: 'bathroom', component: BathroomComponent},
{path: 'bedroom', component: BedroomComponent},
{path: 'kitchen', component: KitchenComponent},
{path: 'living_room', component: LivingRoomComponent},
{path: 'boards', component: BoardsComponent},
{path: 'login', component: LoginComponent},
{path: 'register', component: RegisterComponent},
{path: 'statute', component: StatuteComponent},
{path: 'customer_service', component: CustomerServiceComponent},
{path: 'cart', component: CartComponent},
{path: 'forget_password', component: ForgetPasswordComponent},
{path: 'orders', component: OrdersComponent},
{path: 'complaints', component: ComplaintsComponent},
{path: 'crud', component: AdminCrudComponent},
{path: 'crud_edit/:id', component: AdminCrudEditComponent},
{path: 'crud_add', component: AdminCrudAddComponent},
{path: 'product/:id', component: DetailProductComponent},
{path: 'edit_product/:id', component: EditProductComponent}];


