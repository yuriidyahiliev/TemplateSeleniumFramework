package core.utils;

import io.github.sskorol.core.ScreenshotConsumer;
import org.testng.ITestResult;

import java.time.LocalDate;

import static core.utils.AttachUtils.attachScreenshot;
import static java.util.Objects.nonNull;
import static org.testng.ITestResult.FAILURE;

public class ScreenshotUtils implements ScreenshotConsumer {
    @Override
    public void handle(byte[] screenshot, ITestResult testResult) {
        if (nonNull(screenshot) && testResult.getStatus() == FAILURE) {
            attachScreenshot(screenshot,
                    testResult.getMethod().getMethodName() + "_" + LocalDate.now());
        }
    }
}
