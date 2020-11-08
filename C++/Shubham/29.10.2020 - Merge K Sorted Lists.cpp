/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKListsUtils(ListNode* h1,ListNode* h2){
        ListNode *head=NULL, *temp=NULL;
        while(h1&&h2){
            if(h1->val<h2->val){
                if(head==NULL){
                    head=h1;
                    temp=h1;
                }
                else{
                    temp->next=h1;
                    temp=temp->next;
                }
                h1=h1->next;
            }
            else{
                if(head==NULL){
                    head=h2;
                    temp=h2;
                }
                else{
                    temp->next=h2;
                    temp=temp->next;
                }
                h2=h2->next;
            }
        }
        while(h1){
            if(head==NULL){
                head=h1;
                temp=h1;
            }
            else{
                temp->next=h1;
                temp=temp->next;
            }
            h1=h1->next;
        }
        while(h2){
            if(head==NULL){
                head=h2;
                temp=h2;
            }
            else{
                temp->next=h2;
                temp=temp->next;
            }
            h2=h2->next;
        }
        return head;
    }

    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0)
            return NULL;
        queue<ListNode*> q;
        for(int i=0;i<lists.size();i++)
            q.push(lists[i]);
        ListNode *temp1=NULL,*temp2=NULL,*res=NULL;
        while(q.size()>1){
            printf("Hi\n");
            temp1=q.front();
            q.pop();
            temp2=q.front();
            q.pop();
            res=mergeKListsUtils(temp1,temp2);
            q.push(res);
        }
        return q.front();
    }
};
