import { Injectable } from '@nestjs/common';

@Injectable()
export class TodoService {
  test(): string {
    return 'Hello world';
  }
}
