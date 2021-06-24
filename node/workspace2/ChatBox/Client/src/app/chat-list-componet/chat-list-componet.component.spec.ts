import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChatListComponetComponent } from './chat-list-componet.component';

describe('ChatListComponetComponent', () => {
  let component: ChatListComponetComponent;
  let fixture: ComponentFixture<ChatListComponetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChatListComponetComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChatListComponetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
