package SharedObjects;

import Attributes.IJudgmentAttribute;

public interface IBaseChangeObserver {
    IJudgmentAttribute updateBaseJudges(IJudgmentAttribute object);
   IJudgmentAttribute updateBaseRegulations (IJudgmentAttribute object);
}
