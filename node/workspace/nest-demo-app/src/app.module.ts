import { Module } from '@nestjs/common';
import { TodoModule } from './todo/todo.module';
/**
 * nest uses ioc and dependency injection just like spring
 */
@Module({
  imports: [TodoModule],
  controllers: [],
  providers: [],
})
// imports used to import others modules and also injectables
// controllers used to let module know about @controllers in the module
// providers used to lest module know about @injectables like services, repositories
export class AppModule {}
/**
 * using nest cli
 *
 * nest generate module todo
 * nest g controller todo
 * nest g service todo
 */
